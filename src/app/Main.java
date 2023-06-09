package app;

import java.util.Scanner;

import entities.Audio;
import entities.Image;
import entities.Video;

public class Main {

	public static void main(String[] args) {

		String[][] multimediaElements = new String[5][3];

		for (int i = 0; i < 5; i++) {
			System.out.println("Elemento multimedia n° " + (i + 1));
			multimediaElements[i] = MenuStart();
		}

		int selected = 0;
		Scanner fileSelect = new Scanner(System.in);

		while (true) {
			do {
				System.out.println("\n Seleziona un file:");
				int fileIndex = 0;
				for (String[] el : multimediaElements) {
					fileIndex++;
					System.out.println("\t" + fileIndex + ". " + el[0]);
				}

				selected = fileSelect.nextInt();

			} while (selected > 5 || selected < 0);

			if (selected == 0) {
				fileSelect.close();
				break;
			}

			String[] mediaSelected = multimediaElements[selected - 1];

			if (Integer.parseInt(mediaSelected[1]) == 1) {

				System.out.println("Iniziando riproduzione audio...");
				Audio a = new Audio(mediaSelected[0], Integer.parseInt(mediaSelected[2]));
				a.play();

			} else if (Integer.parseInt(mediaSelected[1]) == 2) {

				System.out.println("Iniziando riproduzione video...");
				Video v = new Video(mediaSelected[0], Integer.parseInt(mediaSelected[2]));
				v.play();
			} else {
				System.out.println("Iniziando visualizzazione immagine...");
				Image i = new Image(mediaSelected[0]);
				i.show();
			}

		}
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