# zombies
_Cloned from https://github.com/benkirchman/Game_

# A group project for CP360 Computer Graphics

### Click Play to play
### WASD to move
### Click screen to shoot toward cursor.
### < Enter > after death to replay.


###### All done with Swing and Graphics2D to illustrate what we had learned in graphics. 
###### Some examples of graphics:
###### Flashlight:

Draws each pixel in chunks of pixels rather than just 1 pixel at a time. The day and night cycles toggle the
flashlight. Day and night are ambient light levels adjusted. The intensity of the flashlight light is
calculated using I = Iambient + the ratio of the radius of the arc at a given point.

###### Sprites:

Each Sprite was drawn on different BufferedImages big enough for the strict boundary of each
Sprite to be able to rotate 360°. This is calculated by seeing how long the longest diagonal of
the rectangle of each Sprite is, and making each diagonal, respectively, the length of the side of
the bigger BufferedImage. This was necessary because the Sprites were drawn in one
orientation and needed to account for getting cut off during rotation. Each sprite was drawn
with a mixture of Path2D.Double, Ellipse2D.Double, and Rectangle2D.Double. The overall shape
of each Sprite was mostly a Path2D.Double. They are rotated using AffineTransform rotate
based off of the angle between the face of the Sprite and the mouse location.

