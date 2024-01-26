import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.preprocessing import LabelEncoder
from sklearn.metrics import accuracy_score
from imblearn.over_sampling import ADASYN
import pickle

def load_data():
    # Replace this URL with the URL of your lung cancer dataset
    url = "D:\ML\survey lung cancer.csv"
    data = pd.read_csv(url)
    return data

def preprocess_data(data):
    # Initialize LabelEncoder
    le = LabelEncoder()

    # Encode categorical columns
    categorical_columns = ['GENDER', 'LUNG_CANCER', 'SMOKING', 'YELLOW_FINGERS', 'ANXIETY', 
                           'PEER_PRESSURE', 'CHRONIC DISEASE', 'FATIGUE ', 'ALLERGY ', 
                           'WHEEZING', 'ALCOHOL CONSUMING', 'COUGHING', 'SHORTNESS OF BREATH',
                           'SWALLOWING DIFFICULTY', 'CHEST PAIN']
    
    for col in categorical_columns:
        data[col] = le.fit_transform(data[col])

    data = data.drop(columns=['GENDER', 'AGE', 'SMOKING', 'SHORTNESS OF BREATH'])

    return data

def split_data(data):
    processed_data = preprocess_data(data)

    # Drop columns from the DataFrame

    X = processed_data.drop('LUNG_CANCER', axis=1)  # Replace 'TargetColumnName' with the name of your target column
    y = processed_data['LUNG_CANCER']  # Replace 'TargetColumnName' with the name of your target column
    
    # Apply ADASYN for over-sampling
    adasyn = ADASYN(random_state=42)
    X_resampled, y_resampled = adasyn.fit_resample(X, y)
    
    # Split the resampled data
    X_train, X_test, y_train, y_test = train_test_split(X_resampled, y_resampled, test_size=0.2, random_state=42)
    return X_train, X_test, y_train, y_test

def train_model(X_train, y_train, model_filename="lung_cancer_model.pkl"):
    model = RandomForestClassifier(n_estimators=100, random_state=42)  # Example: Use 100 trees in the forest
    model.fit(X_train, y_train)

    # Save the model as a pickle file
    with open(model_filename, 'wb') as file:
        pickle.dump(model, file)

    return model

def evaluate_model(model, X_test, y_test):
    predictions = model.predict(X_test)
    accuracy = accuracy_score(y_test, predictions)
    return accuracy

if __name__ == "__main__":
    # Load the lung cancer dataset
    lung_cancer_data = load_data()
    X_train, X_test, y_train, y_test = split_data(lung_cancer_data)

    # Train the model and save as a pickle file
    trained_model = train_model(X_train, y_train, model_filename="lung_cancer_model.pkl")

    # Evaluate the model
    test_accuracy = evaluate_model(trained_model, X_test, y_test)
    print(f"Testing Accuracy: {test_accuracy:.2f}")
