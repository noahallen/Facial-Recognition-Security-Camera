
import pyrebase

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

storage = firebase.storage()


path_on_cloud = "img/dog.png"
path_local = "img/dog.png"

storage.child(path_on_cloud).put(path_local)


