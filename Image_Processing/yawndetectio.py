import cv2

cap = cv2.VideoCapture('eye_recording.flv')

fourcc = cv2.VideoWriter_fourcc(*"XVID")
out = cv2.VideoWriter('output.avi',fourcc,20,(879,526))

while cap.isOpened() :
    ret,frame = cap.read()
    if ret == True :
        roi = frame[269:795,537:1416]
        rows,cols,_ = roi.shape        
        gray_roy = cv2.cvtColor(roi,cv2.COLOR_BGR2GRAY)
        blur = cv2.GaussianBlur(gray_roy,(7,7),0)
        _,thresh = cv2.threshold(blur,3,255,cv2.THRESH_BINARY_INV)
        contours,_ = cv2.findContours(thresh,cv2.RETR_TREE,cv2.CHAIN_APPROX_SIMPLE)
        contours = sorted(contours,key = lambda x : cv2.contourArea(x) , reverse=True)
        
        for contour in contours:
            (x,y,w,h) = cv2.boundingRect(contour)
            cv2.rectangle(roi,(x,y),(x+w,y+h),(0,255,255),2)
            cv2.line(roi,(x + int(w/2),0),(x + int(w/2),rows),(0,255,0),2)
            cv2.line(roi,(0,y + int(h/2)),(cols,y + int(h/2)),(0,255,0),2)
            break
    
        out.write(roi)
        
        cv2.imshow('Frame',roi)
        #cv2.imshow('Gray',gray_roy)
        # cv2.imshow('Blur',blur)
        cv2.imshow('Threshold',thresh)
        
        
        
    if cv2.waitKey(27)  == ord('q') :
        break

cv2.destroyAllWindows()
cap.release()
out.release()    