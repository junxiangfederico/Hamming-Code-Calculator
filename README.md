# Hamming-Code-Calculator

Welcome to my Java and JavaFX based Hamming code calculator. 

# So what is Hamming Code? @link https://en.wikipedia.org/wiki/Hamming(7,4)

In coding theory, Hamming(7,4) is a linear error-correcting code that encodes four bits of data into seven bits by adding three parity bits. 
It is a member of a larger family of Hamming codes, but the term Hamming code often refers to this specific code that Richard W. Hamming introduced in 1950. 
At the time, Hamming worked at Bell Telephone Laboratories and was frustrated with the error-prone punched card reader, which is why he started working on error-correcting codes.

The Hamming code adds three additional check bits to every four data bits of the message. 
Hamming's (7,4) algorithm can correct any single-bit error, or detect all single-bit and two-bit errors. 
In other words, the minimal Hamming distance between any two correct codewords is 3, and received words can be correctly decoded if they are at a distance of at most one from the codeword that was transmitted by the sender. 
This means that for transmission medium situations where burst errors do not occur, Hamming's (7,4) code is effective (as the medium would have to be extremely noisy for two out of seven bits to be flipped).

# How can I use this calculator?

The calculator was built using Java, JavaFX, Scene Builder and Eclipse.
You can clone this repository, compile using Eclipse and the pom.xml included, add the JavaFX arguments, and run.

# And how does this calculator work?

The initial status is as follows:

<img src="/assets/1.png" width=80% height=80%> 

After entering a 4 bits binary sequence, the hamming code codified value is displayed:

<img src="/assets/2.png" width=80% height=80%> 

If an invalid value is entered, an error message is displayed:

<img src="/assets/3.png" width=80% height=80%> 
