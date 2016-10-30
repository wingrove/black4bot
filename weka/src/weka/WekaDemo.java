package weka;

import java.io.BufferedReader;
import java.io.FileReader;

import weka.classifiers.functions.LinearRegression;
import weka.core.Instance;
import weka.core.Instances;

public class WekaDemo {

	public static void main(String[] args) throws Exception {

		Instances data = new Instances(new BufferedReader(new FileReader(
				"/Users/wingrove/Desktop/data/gasPriceV3.arff")));

		data.setClassIndex(data.numAttributes() - 1);

		LinearRegression linearRegression = new LinearRegression();

		linearRegression.buildClassifier(data);

		System.out.println(linearRegression);
		
		//System.out.println();
		//data.instance(index);
		for(int i=19765;i<data.numInstances();i++){
			Instance prediction = data.instance(i);

			double price = linearRegression.classifyInstance(prediction);

			System.out.println(price);
		}
		
		// // TODO Auto-generated method stub
		// Classifier m_classifier = new J48();
		// Classifier zero = new ZeroR();
		//
		// File inputFile = new
		// File("/Users/wingrove/Desktop/data/50States_Month_utf8_v2.csv");
		// ArffLoader atf = new ArffLoader();
		// atf.setFile(inputFile);
		// Instances instancesTrain = atf.getDataSet();
		// //inputFile = new File("arff");
		// //atf.setFile(inputFile);
		// Instances instancesTest = atf.getDataSet();
		// instancesTest.setClassIndex(0);
		// double sum = instancesTest.numInstances(), right = 0.0f;
		// instancesTrain.setClassIndex(0);
		//
		// m_classifier.buildClassifier(instancesTrain);
		// for (int i = 0; i < sum; i++) {
		// if (m_classifier.classifyInstance(instancesTest.instance(i)) ==
		// instancesTest
		// .instance(i).classValue()) {
		// right++;
		// }
		// }
		// System.out.println("J48 classification precision:" + (right / sum));
	}

}
