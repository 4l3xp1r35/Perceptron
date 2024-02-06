import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Example dataset: OR problem
        double[][] inputs = { {0, 0}, {0, 1}, {1, 0}, {1, 1} };
        double[] outputs = {0, 1, 1, 1};
        double[] weights = {1,1,-0.5};
        int train = 6000;

        Perceptron perceptron = new Perceptron(2, 0.1,weights);

        List<Double> mse = perceptron.train(inputs, outputs, train);
        int i = 1;
        double sumError = 0.0;
        for (Double error:mse){
            if(i<11)
            System.out.println("Train "+ i +" com mse de :"+error);
            sumError+=error;
            i++;
        }


        double[] finalWeights = perceptron.getWeights();
        System.out.println(train);
        System.out.println("Trained weights: " + finalWeights[0] + ", " + finalWeights[1]);
        System.out.println("Bias: "+ finalWeights[2]);
        System.out.println("MSE average after training with "+mse.size()+" iterations : "+(sumError/mse.size()));
        }
}
