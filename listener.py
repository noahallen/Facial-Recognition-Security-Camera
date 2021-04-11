from google.cloud import storage

from firebase import firebase
import os

#os.environ["GOOGLE_APPLICATION_CREDENTIALS"]="<add your credentials path>"

firebase = firebase.FirebaseApplication('https://ss-facialrecognition-default-rtdb.firebaseio.com/')


client = storage.Client()

bucket = client.get_bucket('gs://ss-facialrecognition.appspot.com/')



imageBlob = bucket.blob("/")

imagePath = "img/dog.png"

imageBlob = bucket.blob("dog.png")

imageBlob.upload_from_filename(imagePath)