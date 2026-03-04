# Location 

This is a simple Android app that retrieves the device's GPS location and displays latitude and longitude. 
The app demonstrates **MVVM architecture** using **ViewModel** and **LiveData**, implemented in **Kotlin + Jetpack Compose**.

## Screenshots

<table>
    <tr>
        <td><img src="img.png" width="250" height="auto" title="Home screen" alt="Overview of home screen displaying screen title and navigation possibilities"></td>
        <td><img src="img_1.png" width="250" height="auto" title="Location screen" alt="Overview of location screen displaying title, texts and current results for latitude & longitude and button to trigger location retrieval."></td>
    </tr>
    <tr>
        <td><img src="img_2.png" width="250" height="auto" title="Permission request" alt="Displays GPS permission grant options"></td>
        <td><img src="img_3.png" width="250" height="auto" title="Location results" alt="Displays location results for latitude & longitude after permission for the app to use GPS has been granted"></td>
    </tr>
</table>


## Features
- Home screen and location screen with TopBar navigation
- Home screen also includes button for redirection to location screen
- On location screen displays current latitude and longitude as decimal numbers after button press and permissions granted
- Requests runtime permission for location using `Accompanist Permissions`
-  "Get location" -button triggers permission request and updates coordinates
- Uses `ViewModel` and `LiveData` for state management

## Running the app
This project was created using Android Studio. To clone and run the project:

```bash
- git clone https://github.com/Anniina-55/Location.git 
- cd Location
- open project in Android Studio
- build and run on emulator or physical device