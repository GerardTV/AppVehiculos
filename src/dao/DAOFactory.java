package dao;

public class DAOFactory {

    public static VehiculoDAO getVehiculoDAO(TipoPersistencia tipo) {

        switch (tipo) {

            case BBDD:
                return new VehiculoDAOBBDD();

            case FICHERO:
                return new VehiculoDAOFile();

            default:
                throw new IllegalArgumentException("Tipo de persistencia no válido: " + tipo);
        }
    }
}