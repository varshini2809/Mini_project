import streamlit as st
import pandas as pd
import numpy as np
import pickle
from sklearn.preprocessing import LabelEncoder, StandardScaler

# Load the pre-trained model
with open("lung_cancer_model.pkl", "rb") as model_file:
    model = pickle.load(model_file)

# Streamlit UI
st.title("Lung Cancer Prediction")

# Input form
st.sidebar.header("Patient Information")

def user_input_features():
    yellow_fingers = st.sidebar.selectbox("YELLOW_FINGERS", [2,1], key='yellow_fingers')
    anxiety = st.sidebar.selectbox("ANXIETY", [2,1], key='anxiety')
    peer_pressure = st.sidebar.selectbox("PEER_PRESSURE",[1,2],key='peer_pressure')
    chronic_disease = st.sidebar.selectbox("CHRONIC DISEASE", [1,2], key='chronic_disease', help="Whether the patient has a chronic disease")
    fatigue = st.sidebar.selectbox("FATIGUE ",[2,1],key='fatigue')
    allergy = st.sidebar.selectbox("ALLERGY ",[1,2],key='allergy')
    wheezing = st.sidebar.selectbox("WHEEZING", [2,1], key='wheezing', help="Whether the patient experiences wheezing")
    alcohol = st.sidebar.selectbox("ALCOHOL CONSUMING", [2,1], key='alcohol')
    coughing = st.sidebar.selectbox('COUGHING',[2,1],key='coughing')
    swallow = st.sidebar.selectbox('SWALLOWING DIFFICULTY',[2,1],key='swallow')
    chest_pain = st.sidebar.selectbox("CHEST PAIN", [2,1], key='chest_pain', help="Whether the patient experiences chest pain")

    data = {
        'YELLOW_FINGERS': yellow_fingers,
        'ANXIETY': anxiety,
        'PEER_PRESSURE':peer_pressure,
        'CHRONIC DISEASE': chronic_disease,
        'FATIGUE ':fatigue,
        'ALLERGY ':allergy,
        'WHEEZING': wheezing,
        'ALCOHOL CONSUMING':alcohol,
        'COUGHING':coughing,
        'SWALLOWING DIFFICULTY':swallow,
        'CHEST PAIN': chest_pain
    }

    features = pd.DataFrame(data, index=[0])
    features =features[['YELLOW_FINGERS','ANXIETY','PEER_PRESSURE','CHRONIC DISEASE','FATIGUE ','ALLERGY ','WHEEZING','ALCOHOL CONSUMING','COUGHING','SWALLOWING DIFFICULTY','CHEST PAIN']]
    
    categorical_columns = ['YELLOW_FINGERS', 'ANXIETY','PEER_PRESSURE', 'CHRONIC DISEASE', 'FATIGUE ', 'ALLERGY ', 
                           'WHEEZING', 'ALCOHOL CONSUMING', 'COUGHING',
                           'SWALLOWING DIFFICULTY', 'CHEST PAIN']
    
    for col in categorical_columns:
        features[col] = LabelEncoder().fit_transform(features[col])

    return features

input_df = user_input_features()

# Show the input data
st.subheader("Patient Information:")
st.write(input_df)

# Make predictions
prediction = model.predict(input_df)
st.write(prediction)  # Add this line to check the predicted value

# Display prediction
st.subheader("Prediction:")
st.write("Risk of lung cancer" if prediction[0] == 1 else "Low risk of lung cancer")
