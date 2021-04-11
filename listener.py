
import pyrebase
import time
import os

config = {
    "apiKey": "AIzaSyBq1xCymVdKC2LI6EvDaavMOCW_bFfABow",
    "authDomain": "ss-facialrecognition.firebaseapp.com",
    "databaseURL": "https://ss-facialrecognition-default-rtdb.firebaseio.com",
    "projectId": "ss-facialrecognition",
    "storageBucket": "ss-facialrecognition.appspot.com",
    "messagingSenderId": "52328822573",
    "appId": "1:52328822573:web:3b251230bc3fbbf1a845a4",
    "measurementId": "G-HC4192BM1Y"
}

firebase = pyrebase.initialize_app(config)

t = 0
storage = firebase.storage()
while(True):
    if (time.time() - t) > 1:
        t = time.time()
        for filename in os.listdir(directory):
            if filename.endswith(".jpg") or filename.endswith(".png"):
                path_on_cloud = (os.path.join(directory, filename))
                path_local = path_on_cloud
                storage.child(path_on_cloud).put(path_local)

                os.remove(path_local)
            else:
                continue




