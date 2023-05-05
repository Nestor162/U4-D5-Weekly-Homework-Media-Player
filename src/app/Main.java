package app;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

//		Audio a1 = new Audio("Never Gonna Give You Up", 3);
//		a1.setVolume(1);
//		a1.volumeUp();
//		a1.play();

//		Video v1 = new Video("Me at the zoo", 4);
//		v1.setBrightness(5);
//		v1.brdecrease();
//		v1.brdecrease();
//		v1.play();

//		Image i1 = new Image("kitten.png");
//		i1.brdecrease();
//		i1.brdecrease();
//		i1.show();

		String[][] multimediaElements = new String[5][3];

		for (int i = 0; i < 5; i++) {
			System.out.println("Elemento multimedia n° " + (i + 1));
			multimediaElements[i] = MenuStart();
		}

		int selected = 0;
		Scanner fileSelect = new Scanner(System.in);
		do {
			System.out.println("Seleziona un file:");
			int fileIndex = 0;
			for (String[] el : multimediaElements) {
				fileIndex++;
				System.out.println("\t" + fileIndex + ". " + el[0]);
			}
			selected = fileSelect.nextInt();
		} while (selected != 0);

	}

	public static String[] MenuStart() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci il titolo del elemento multimediale:");
		String title = sc.nextLine();
		int type;

		do {
			System.out.println("Selezionare tipo: 1.Audio / 2.Video / 3.Immagine");
			type = sc.nextInt();
			if (type > 3 || type < 1) {
				System.out.println("Per favore, inserire un numero valido");
			}
		} while (type > 3 || type < 1);

		int duration;

		if (type == 1 || type == 2) {
			System.out.println("Inserisci la durata:");
			duration = sc.nextInt();
		} else {
			duration = 0;
		}

		String[] data = { title, Integer.toString(type), Integer.toString(duration) };

		return data;
	}
}