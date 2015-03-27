# QRCodeGenerator
<p>
QR code (Quick Response Code) is the trademark for a type of matrix barcode (or two-dimensional barcode) first designed for the automotive industry in Japan. A barcode is a machine-readable optical label that contains information about the item to which it is attached. A QR code uses four standardized encoding modes (numeric, alphanumeric, byte / binary, and kanji) to efficiently store data; extensions may also be used. Read more(Wikipedia) .
</p>
<p>
The QR Generator app is purely built in Java SE for backend and Java Swing for the UI, using the Model View Controller approach. It relies on XZing Library to build the QR and generate the 2D code image that can be exported to the local file system. To read the QR image, you will need to a QR Scanner or the many apps that can scan QR codes using mobile phone camera.
Below is a typical screen of the application running, with the custom color scheme drop-down active in Windows 7. The L&F may differ depending on how your OS renders the UI components, since the application uses the System Default Look & Feel.
</p>
<p>
<img src="https://iworkslabs.files.wordpress.com/2015/03/qr_generator_1.png"/>
</p>
# How to use the application (.jar) / (Running the binaries)
<p>
A JRE 1.6 or later is required to run the application. Download the zip and unzip dist folder to a convinient folder. Ensure tha the following directories are present in the dist folder :- codes, icons, dist. These (folders)files are  neccessary for the app to run. If everyting is okay double clicking on the .jar file will launch the application. Enjoy
</p>
# Setting up the project in Netbeans/Eclipse or any other IDE / (Compiling the sources)


