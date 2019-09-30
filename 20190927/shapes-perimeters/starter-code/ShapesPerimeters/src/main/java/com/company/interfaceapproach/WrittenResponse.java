/*  Given the three approaches, abstract class implementation, interface implementation, and the use of concrete classes
* I believe that the implementation of an interface in conjunction with an abstract class would best solve the problem.
*  Although all three options are valid given my understanding of the concepts I think this combination would be the
*  most efficient.
*   I think that having an interface where you declare a method for calculating perimeter could be used for both the
* square and the triangle, where the method would be the same where in the calculation would just be adding up the
* length of the sides but would take in different parameters given they do not have the same number of sides. The
* interface would not be implemented on the circle class because it's perimeter is calculated in a unique way.
*   Creating an abstract class that would assign coordinates and color to each shape would work well because each of
* the shapes share these props and none stand out. Creating all of the classes concretely would work but to achieve
* drier code using an abstract class along with an interface would be more efficient. */
