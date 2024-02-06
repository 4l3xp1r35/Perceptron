import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Perceptron {
    private double[] weights;
    double learningRate;

    /**
     * Constructor for creating a Perceptron with predefined weights and a learning rate.
     * Allows for the initialization of the Perceptron with specific weights.
     *
     * @param numberOfWeights The number of weights (excluding the bias) for the Perceptron.
     * @param learningRate The learning rate for the Perceptron.
     * @param givenWeights An array of initial weights, including the bias as the first element.
     */
    public Perceptron(int numberOfWeights, double learningRate, double[] givenWeights) {
        // Initialize weights with small random values, the first weight is the bias
        this.weights = new double[numberOfWeights+1];
        for (int i = 0; i < numberOfWeights+1; i++) {
            this.weights[i] = givenWeights[i];
        }
        this.learningRate = learningRate;
    }

    /**
     * The sigmoid activation function for the Perceptron.
     * Applies the sigmoid function to the input value.
     *
     * @param z The input value to the sigmoid function.
     * @return The output of the sigmoid function.
     */
    private double sigmoid(double z) {
        return 1.0 / (1.0 + Math.exp(-z));
    }

    public double predict(double[] inputs){
        double sum = weights[2];
        for (int i = 0; i<inputs.length;i++){
            sum+=weights[i]*inputs[i];
        }
        return sigmoid(sum);
    }

    /**
     * Trains the Perceptron using a set of input data and expected outputs.
     * Training is carried out for a specified number of iterations, adjusting the weights of the Perceptron
     * based on the errors between predictions and expected outcomes. This method employs the gradient descent algorithm
     * to optimize the weights.
     *
     * During training, the method calculates the mean squared error (MSE) in each iteration,
     * which is a measure of the performance of the Perceptron. The MSE is added to a list that is returned
     * after the training, allowing for analysis of the learning process.
     *
     * @param inputMatrix Input matrix where each row represents a set of inputs for the Perceptron.
     * @param outputs Array of expected outputs for each input set in the input matrix.
     * @param iterations Number of iterations to run the training.
     * @return A list of mean squared error (MSE) values for each iteration,
     *         indicating the performance of the Perceptron over time.
     */
    public List<Double> train(double[][] inputMatrix, double[] outputs, int iterations){
        List<Double> mse = new ArrayList<>();
        for (int i = 0; i<iterations;i++){
            double finalError=0;
            for (int j = 0;j<inputMatrix.length;j++){
                double pred = predict(inputMatrix[j]);
                double error = outputs[j] - pred;
                double errorSquare = Math.pow(error,2);
                finalError+=errorSquare;
                weights[0] += learningRate * error * inputMatrix[j][0];
                weights[1] += learningRate * error * inputMatrix[j][1];
                weights[2] += learningRate * error;
            }
            mse.add(finalError/inputMatrix.length);
        }
        return mse;
    }

    public double[] getWeights() {
        return weights;
    }
}
