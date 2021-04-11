from google.cloud import storage

from firebase import firebase
import os

#os.environ["GOOGLE_APPLICATION_CREDENTIALS"]="<add your credentials path>"

firebase = firebase.FirebaseApplication('https://console.firebase.google.com/project/ss-facialrecognition/storage/ss-facialrecognition.appspot.com/files')


client = storage.Client()

bucket = client.get_bucket('img/')



imageBlob = bucket.blob("/")

imagePath = "img/dog.png"

imageBlob = bucket.blob("dog.png")

imageBlob.upload_from_filename(imagePath)