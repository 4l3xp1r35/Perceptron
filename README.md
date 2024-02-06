# README: Perceptron Implementation for the OR Problem

## Overview
This project implements a perceptron in Java to solve the logical OR problem. It uses the generalized delta rule to adjust the perceptron's weights, aiming to minimize the mean squared error (MSE) during training. The perceptron is trained with a dataset representing the inputs and outputs of the OR problem.

## Implementation
- `Perceptron.java`: Defines the Perceptron class, responsible for the model's initialization, training, and evaluation. It includes methods for adjusting weights based on the error calculated using the sigmoid activation function.
- `Main.java`: Contains the main method to demonstrate training the perceptron on the OR problem. It sets up the training dataset, initializes the perceptron with specific weights, and conducts training to adjust the weights.

## Features
- Definition and use of a linearly separable binary dataset for the OR problem.
- Calculation and adjustment of the perceptron's weights without prior training, using the generalized delta rule.
- Evaluation of the perceptron's performance by calculating the MSE during training.

## How to Run
To run this project, compile and execute the `Main.java` file.

The comand for compile:
                
    javac Main.java

The comand for run:  

    java Main

 This will initiate the perceptron's training process and display the results, including the adjusted weights and the average MSE after training.

## Conclusion
The project demonstrates the effectiveness of the perceptron in correctly classifying inputs for the logical OR problem, adjusting its synaptic weights to minimize error. The Java implementation provides a solid foundation for exploring neural network concepts and machine learning.
