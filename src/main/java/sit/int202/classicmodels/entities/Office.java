package sit.int202.classicmodels.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Offices")
@Getter
@Setter
@NamedQueries(
        {
                @NamedQuery(name = "OFFICE.FIND_ALL", query = "select o from Office o"),
                @NamedQuery(name = "OFFICE.FIND_BY_COUNTRY",
                        query = "select o from Office o where o.country like :country")
        }
)
public class Office {
    @Id
    private String officeCode;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String postalCode;
//    @Column(name = "phone")
    private String phone;
    private String territory;

    @OneToMany(mappedBy = "officeCode")
    private List<Employee> employeeList;

    public static void addNewOffice(String officeCode, String addressLine1, String city, String state,
                                    String country, String postalCode, String phone, String territory) {
        // Create an EntityManagerFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

        // Create an EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Create a new Office instance
        Office newOffice = new Office();
        newOffice.setOfficeCode(officeCode);
        newOffice.setAddressLine1(addressLine1);
        newOffice.setCity(city);
        newOffice.setState(state);
        newOffice.setCountry(country);
        newOffice.setPostalCode(postalCode);
        newOffice.setPhone(phone);
        newOffice.setTerritory(territory);

        // Start a transaction
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // Persist the new office
        entityManager.persist(newOffice);

        // Commit the transaction
        transaction.commit();

        // Close the EntityManager and EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
    public static List<String> getColumnNames() {
        List<String> columnNames = new ArrayList<>();

        // Use reflection to get declared fields
        Field[] fields = Office.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column columnAnnotation = field.getAnnotation(Column.class);
                String columnName = columnAnnotation.name();

                columnNames.add(field.getName());
            }
            System.out.println(columnNames.add(field.getName()));
//            System.out.println(Column.class.getName());
        }

        return columnNames;
    }




}

