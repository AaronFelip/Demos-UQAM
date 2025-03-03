/**
 * Cette permet de lire un fichier JSON et de compter le nombre d'albums et singles quelle contient ainsi
 * que les albums ou singles ayant un rating de 5, et les albums ou singles paru à partir de 2003.
 *
 * @Author: Aaron Osorio
 * @Courriel: moncourriel@courriel.com
 * @Code-permamnent: AAAA82090909
 * @Groupe: 30
 */

/**
 * Import des classes nécessaires pour la gestion des exceptions liées aux fichiers
 */

import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException; // Cette classe est utilisée pour gérer les exceptions liées à un fichier introuvable.
import java.io.IOException; // Cette classe est utilisée pour gérer les exceptions liées à des erreurs d'entrée/sortie.

// Import de la classe ArrayList depuis le package java.util
import java.util.ArrayList; // Cette classe permet de créer et de manipuler des listes d'objets de manière dynamique.

public class AlbumStats {

    /**
     * Le point d'entrée du programme. Cette méthode lit un fichier JSON, compte le nombre d'albums et de singles
     * qu'il contient, ainsi que les albums ou les singles ayant un rating de 5, et les albums ou les singles
     * parus à partir de 2003.
     *
     * @param args Les arguments de la ligne de commande (non utilisés dans cette application).
     */
    public static void main(String[] args) {

        String nomFichierJSON = "collection.json";

        try {
            // Utilisez la méthode jsonFileToAlbum de la classe JsonParser pour lire le fichier JSON
            ArrayList<Album> albums = JsonParser.jsonFileToAlbum(nomFichierJSON);

            // Appel de la méthode calculerInformationsDansJSON pour effectuer des calculs sur les albums
            calculerInformationsDansJSON(albums, nomFichierJSON);

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (ParseException e) {

            e.printStackTrace();

        }

    }

    /**
     * Cette méthode effectue des calculs statistiques sur une liste d'albums, y compris le nombre total d'albums,
     * le nombre total de singles, le nombre d'albums ou de singles parus à partir de 2003, et le nombre d'albums
     * ou de singles ayant un rating de 5.
     *
     * @param albums La liste d'albums à analyser.
     * @param nomFicherJSON le nom du fichier
     */
    private static void calculerInformationsDansJSON( ArrayList < Album > albums, String nomFicherJSON ) {

        int nombreAlbums = 0;
        int nombreSingles = 0;
        int albumsParuAPartir2003 = 0;
        int ratingParfait = 0;

        for ( Album album : albums ) {

            //Compteur pour connaître le nombre d'albums contenu dans le fichier JSON
            if ( album.getType().equals( "album" ) ) {

                nombreAlbums++;

            } else {

                //Compteur pour connaître le nombre de singles contenu dans le fichier JSON
                nombreSingles++;

            }
            //Permet d'aller chercher les albums et singles publiés à partir de 2003
            if ( album.getPublication() >= 2003 ) {

                albumsParuAPartir2003++;

            }
            //Permettra d'aller chercher les albums et singles avec un rating égal à 5
            if ( album.getRating() == 5 )

                ratingParfait++;

        }

        System.out.println( "Le fichier JSON " + nomFicherJSON + " contient: \n" +
                nombreAlbums + " albums,\n" +
                nombreSingles + " singles,\n" +
                albumsParuAPartir2003 + " albums paru à partir de 2003,\n" +
                ratingParfait + " albums ou singles ayant un rating de 5.\n" );

    }

}