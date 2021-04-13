
import pyrebase
import time
import os

import logging, sys

logging.basicConfig()
logger = logging.getLogger(__name__)
logger.setLevel(logging.INFO)

DIRECTORY = 'img/'
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
db = firebase.database()
while(True):
    if (time.time() - t) > 1:
        t = time.time()
        for filename in os.listdir(DIRECTORY):
            if filename.endswith(".jpg") or filename.endswith(".png"):
                path_on_cloud = (os.path.join(DIRECTORY, filename))
                path_local = path_on_cloud
                storage.child(path_on_cloud).put(path_local)
                logger.info("File {} pushed to FIREBASE".format(filename))
                
                raw = filename.split('-')

                img = storage.child(path_local).get_url(None)
                name = raw[4][:-4] #split raw, take name, chop off png
                
                s='-'
                raw = s.join(raw[:4])
                timmy = raw

                data = {"img":img, "name":name, "time":timmy}
                db.child("visitors/").push(data)
                logger.info("File {} now availible at: {}".format(filename, img))
                os.remove(path_local)
            else:
                continue




