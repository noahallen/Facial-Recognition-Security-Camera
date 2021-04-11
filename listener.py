#!/usr/bin/env python
import sys
import requests
import firebase_admin
from firebase_admin import credentials
from firebase_admin import storage

image_url = "gs://ss-facialrecognition.appspot.com/img" #we pass the url as an argument

cred = credentials.Certificate('Firebase/Certificate.json')
firebase_admin.initialize_app(cred, {
    'storageBucket': 'gs://ss-facialrecognition.appspot.com'
})
bucket = storage.bucket()

image_data = requests.get(image_url).content
blob = bucket.blob('dog.png')
blob.upload_from_string(
        image_data,
        content_type='image/png'
    )
print(blob.public_url)