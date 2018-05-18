<p align="center"><img width=12.5% src="https://github.com/ChmaraX/logregform-android/blob/master/app/src/main/res/drawable/logo_noshadow.png"></p>
<p align="center" text> <b>Authentication form for Android </p>

<p align="center">
<img src="https://img.shields.io/pypi/status/Django.svg"/>
<a href="https://codeclimate.com/github/ChmaraX/logregform-android/maintainability"><img src="https://api.codeclimate.com/v1/badges/c3bd5593b9920bf9022a/maintainability"/></a>
<a href="https://github.com/ChmaraX/logregform-android/issues"><img src="https://img.shields.io/github/issues/ChmaraX/logregform-android.svg"/></a>
<img src="https://img.shields.io/badge/contributions-welcome-orange.svg"/>
<a href="https://github.com/ChmaraX/logregform-android/blob/master/LICENSE"><img src="https://img.shields.io/badge/license-MIT-blue.svg"></a>
</p>


## Basic Overview

> Android authentication form based on Firebase with few features, custom animation and design. 

## Features

- [x] Registration activity with email and password, also storing and username into database. 
- [x] Login activity with email/password, remembering logged user. 
- [x] Password reset activity (sending an email to user)
- [x] Wrong inputs errors
- [x] Welcome splash screen
- [x] Button gradients (on-click transitions)
- [ ] Social app login (not connected to API)



## Interface Preview 

<p align="center">
  <img src="https://raw.githubusercontent.com/ChmaraX/logregform-android/master/Preview/3.jpeg" width="210"/>
  <img src="https://raw.githubusercontent.com/ChmaraX/logregform-android/master/Preview/4.jpeg" width="210"/>
  <img src="https://raw.githubusercontent.com/ChmaraX/logregform-android/master/Preview/1.jpeg" width="210"/>
  <img src="https://raw.githubusercontent.com/ChmaraX/logregform-android/master/Preview/2.jpeg" width="210"/>
</p>

#### Splashscreen
 <img src="https://raw.githubusercontent.com/ChmaraX/logregform-android/master/Preview/splash.gif" width="210"/>

## Implementation

#### google-services.json
You need to set up your own [Firebase](https://firebase.google.com/) authenticator + database and download `google-services.json` file, then add it to `YourApp/app` folder:

The dependencies are already set up.

``` Java
dependencies {

...
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.1'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.1'

    compile 'com.google.firebase:firebase-core:15.0.0'
    compile 'com.google.firebase:firebase-auth:15.0.0'
    compile 'com.google.firebase:firebase-database:15.0.0'

}
```
