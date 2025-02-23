package vectors;

import java.util.Scanner;

public class Matrix {

	public static int[] matrixDiagonal(int[][] mat) {
		
		int[] diagonal = new int[mat.length];
		
		//A menor matriz diagonal possivel e 2x2
		if (mat.length == mat[1].length) {
			for (int i = 0; i < mat.length; i++) {
				diagonal[i] = mat[i][i];
			}
		}
		
		else {
			System.out.println("THE MATRIX IS NOT SQUARE");
		}
		
		return diagonal;
	}
	
	public static int[][] matrixGenerator(int linhas, int colunas, Scanner sc){
		
		//Inicializacao de uma matriz quadrada
		int[][] mat = new int[linhas][colunas];
		int count = 0;
		
		//Laço percorrendo as linhas
		for (int i=0; i < mat.length; i++) {
			
			//Laco percorrendo as colunas
			for (int j = 0; j < mat[i].length ; j++) {
				
				count += 1;
				
				//Preenchendo os elementos da matriz
				System.out.printf("Enter the %dº number: ", count);
				mat[i][j] = sc.nextInt();
			}
		}
		
		return mat;
	}
	
}



