#!/usr/bin/env python
from jose import jwt

token = jwt.encode(
    {
        'sub': '1234567890',
        'name': 'John Doe',
        'aud': [
            'my-cloud-app'
        ]
    },
    'supersecretkey',
    algorithm='HS256'
)
print(token)
