# moopig
Raspberry Pi based mono synthesiser

If you take a Moog and put a Pi in it, you get Moopig.

The system requires a Pi2 or 3, a MIDI to USB interface and a MIDI keyboard.

An attempt to recreate a 1970s monophonic synthesiser using a Raspberry Pi. It consists of a tone generator server, and a controlling client. The client was made using the PureData visual programming language and handles the keyboard and all the control switches and dials. The server uses Java on top of the HappyBrackets/BEADs libraries. The interface between the two is OSC so you can replace the client with your own control clients.

Although the server runs on a Pi, it is standard Java so it should run on any modern computer.

## Client
Install http://puredata.org and load the moopig.pd code.  Developed with Pure Data 0.47-1

  * Add your Midi adapter using File->Preferences->MIDI settings.
  * Put the IP address of your Pi into the "connect" box. (Use CTRL-E to toggle between edit and run mode)
  * If you are running you can see the numbers under "notein" change when you play your keyboard.
  * To send OSC messages, click connect. You will see a "1" appear under "netsend" when you are running.

## Server

The server uses HappyBrackets for convenience. Experts might wish to convert this to a BEADS project. The installation is detailed at https://github.com/orsjb/HappyBrackets/wiki/Getting-Started. Skip past the "Setting up your computer" part unless you want to do Java development. Instead just do the "Setting up your Raspberry Pi" part.

  * Create a HappyBrackets/Rasbian SD card. Follow either set of instructions.
  * Undo the network changes (restore your own WiFi settings).
  * Install moopig classes. These go in <path>\net\happybrackets\peter
  * Set HappyBrackets to auto run by editing the startup script.
