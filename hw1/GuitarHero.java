/* Write a program GuitarHero that is similar to GuitarHeroLite, but supports a total of 37 notes on the chromatic scale from 110Hz to 880Hz. Use the following 37 keys to represent the keyboard, from lowest note to highest note:

String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

This keyboard arrangement imitates a piano keyboard: The "white keys" are on the qwerty and zxcv rows and the "black keys" on the 12345 and asdf rows of the keyboard.

The ith character of the string keyboard corresponds to a frequency of 440 × 2^((i - 24) / 12), so that the character 'q' is 110Hz, 'i' is 220Hz, 'v' is 440Hz, and ' ' is 880Hz. Create an array of 37 GuitarString objects and use keyboard.indexOf(key) to figure out which key was typed. Make sure your program does not crash if a key is pressed that does not correspond to one of your 37 notes.*/

import synthesizer.GuitarString;

public class GuitarHero {

    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        synthesizer.GuitarString[] guitarStringObjects = new GuitarString[37];
        synthesizer.GuitarString stringX;
        synthesizer.GuitarString stringToPlay;

        for (int i = 0; i < 37; i++)
        {
            double freq = 440.0 * Math.pow(2.0, (i - 24.0) / 12.0);
            stringX = new synthesizer.GuitarString(freq);
            guitarStringObjects[i] = stringX;
        }

        while (true)
        {
            /* check if the user has typed a key; if so, get the index,
            then find the corresponding guitarstring at that index in the guitar objects */
            if (StdDraw.hasNextKeyTyped())
            {
                char inputKey = StdDraw.nextKeyTyped();
                int indexOfInputKey = keyboard.indexOf(inputKey);
                if (indexOfInputKey == -1) continue;
                stringToPlay = guitarStringObjects[indexOfInputKey];
                stringToPlay.pluck();
            }

            // compute the superposition of samples
            double sample = 0.0;
            for (GuitarString x : guitarStringObjects)
            {
                sample += x.sample();
            }
            
            // play the sample on standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for (GuitarString x: guitarStringObjects)
            {
                x.tic();
            }
        }
    }
}