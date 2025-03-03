/**
 * Cette classe représente un objet Album qui contient des informations telles que le type (album ou single),
 * l'artiste, le titre, l'année de publication et le rating (note).
 *
 * @Author: Aaron Osorio
 * @Courriel: moncourriel@courriel.com
 * @Code-permamnent: AAAA82090909
 * @Groupe: 30
 */

public class Album {

    /**
     * Ces champs de classe représentent les caractéristiques essentielles d'un album ou d'un single :
     * - 'type' : Le type de l'album (album ou single).
     * - 'titre' : Le titre de l'album ou du single.
     * - 'artiste' : Le nom de l'artiste ou du groupe musical.
     * - 'publication' : L'année de publication de l'album ou du single.
     * - 'rating' : Le rating (note) attribué à l'album ou au single.
     */
    private String type;
    private String titre;
    private String artiste;
    private int publication;
    private int rating;

    /**
     * Constructeur de la classe Album.
     *
     * @param type Le type de l'album (album ou single).
     * @param artiste Le nom de l'artiste.
     * @param titre Le titre de l'album ou du single.
     * @param publication L'année de publication.
     * @param rating Le rating (note) de l'album ou du single.
     */
    public Album ( String type, String artiste, String titre, int publication, int rating ){
        this.artiste = artiste;
        this.titre = titre;
        this.type = type;
        this.publication = publication;
        this.rating = rating;
    }

    /**
     * Récupère le type de l'album (album ou single).
     *
     * @return Le type de l'album.
     */
    public String getType() {

        return type;

    }

    /**
     * Récupère le titre de l'album ou du single.
     *
     * @return Le titre de l'album ou du single.
     */
    public String getTitre() {

        return titre;

    }

    /**
     * Récupère le nom de l'artiste.
     *
     * @return Le nom de l'artiste.
     */
    public String getArtiste() {

        return artiste;

    }

    /**
     * Récupère l'année de publication.
     *
     * @return L'année de publication.
     */
    public int getPublication() {

        return publication;

    }

    /**
     * Récupère le rating (note) de l'album ou du single.
     *
     * @return Le rating (note) de l'album ou du single.
     */
    public int getRating() {

        return rating;

    }

}