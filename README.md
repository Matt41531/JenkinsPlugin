# JenkinsPlugin
The purpose of this plugin is to enter mathematical equations and receive the edge cases for that particular expressions
To enter is an expression it must be in the form of variable name plus a constant

Example:
input: x + 2
output: Possible test cases for x: -2, 127482834782343


Code Structure:
The line is passed in from the user and then the parsed so that the variable, operation, and constant can be separated. Then the plugin functions as a inverse calculator to determine the edge cases for a program to use. Then the plugin also generates a random input for the expression type. 
