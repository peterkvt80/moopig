# moopig
Raspberry Pi based mono synthesiser

If you take a Moog and put a Pi in it, you get Moopig.

The system requires a Pi2 or 3, a MIDI to USB interface and a MIDI keyboard.

An attempt to recreate a 1970s monophonic synthesiser using a Raspberry Pi. It consists of a tone generator server, and a controlling client. The client was made using the PureData visual programming language and handles the keyboard and all the control switches and dials. The server uses Java on top of the HappyBrackets/BEADs libraries. The interface between the two is OSC so you can replace the client with your own control clients.

Although the server runs on a Pi, it is standard Java so it should run on any modern computer.

## Client
  * Install PureData from http://puredata.org and load the moopig.pd code.  Developed with Pure Data 0.47-1

  * Add your Midi adapter using File->Preferences->MIDI settings.
  * Put the IP address of your Pi into the "connect" box. (Use CTRL-E to toggle between edit and run mode)
  * If you are running you can see the numbers under "notein" change when you play your keyboard.
  * To send OSC messages, click connect. You will see a "1" appear under "netsend" when you are running.

## Server

The server uses HappyBrackets for convenience. Experts might wish to convert this to a BEADS project. The installation is detailed at https://github.com/orsjb/HappyBrackets/wiki/Getting-Started. Skip past the "Setting up your computer" part unless you want to do Java development. Instead just do the "Setting up your Raspberry Pi" part. There are several ways to configure a system. This is the way I did it from a new NOOBs card.
  * Start your Pi with a new NOOBs SD card.
  * Select the "Rasbian with PIXEL" option.
  * Get your Pi online by ethernet or WiFi.
  * Follow the instructions for setting up HappyBrackets on the Pi by script (option 2). https://github.com/orsjb/HappyBrackets/wiki/Getting-Started WARNING: Do not follow the extra instructions about changing your network to Pinet. 
  * Type ifconfig in the shell to find your IP address. You need to enter this into the client. Mine was 192.168.1.9.
  * Install the moopig classes (eight of them at the last count). On the Pi make this directory path /home/pi/HappyBrackets/data/classes/net/happybrackets/peter. Place the class files in there. More information about this at https://github.com/orsjb/HappyBrackets/wiki/Copying-Audio-and-Classes-and-Autorunning-Actions
  * Set HappyBrackets to auto run by editing the startup script. 
    nano ~/HappyBrackets/scripts/run.sh
    and set the ACTION line as follows
    ACTION=net.happybrackets.peter.moopig
    
* Troubleshooting
Is HappyBrackets running? When you boot you should hear a tone when it starts. If you are using the minijack for audio and you have HDMI plugged in then it might be diverting the audio that way. Unplug the HDMI and reboot.

Is HappyBrackets configured to run Moopig? Open a console and start and stop HappyBrackets.

  cd ~/HappyBrackets
  sudo killall java
  sudo ./scripts/run.sh

If you have any errors then this will show you a traceback
  
