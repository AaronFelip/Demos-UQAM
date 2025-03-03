public class CalculateurTaxes {

    static final double TAXE_FEDERALE = 0.05;
    static final double TAXE_PROVINCIALE = 0.09975;

    static long calculerTaxes ( long sous, boolean taxeFederal, boolean taxeProvincial ){

        long resultat = sous;

        if ( resultat <= 0 ){

            throw new IllegalArgumentException( "Montant incorrect" );

        } else {

            if ( taxeFederal ) resultat += Math.round( sous*TAXE_FEDERALE );
            if ( taxeProvincial ) resultat += Math.round( sous*TAXE_PROVINCIALE );

        }

        return resultat;

    }

}
