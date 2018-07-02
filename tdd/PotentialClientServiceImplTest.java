package com.srlpunto.resources.PotentialClient.service;
import com.srlpunto.api.PotentialClient;
import com.srlpunto.api.enums.ClientType;
import com.srlpunto.core.exceptions.ExistException;
import com.srlpunto.resources.Client.dao.ClientDao;
import com.srlpunto.resources.Client.dao.ClientDaoImpl;
import com.srlpunto.resources.PotentialClient.dao.PotentialClientDao;
import com.srlpunto.resources.PotentialClient.dao.PotentialClientImpl;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.junit.Before;
import org.junit.Test;

import javax.transaction.Synchronization;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Ruth on 30/06/2018.
 */
public class PotentialClientServiceImplTest {

    private PotentialClientDao potentialClientDao;
    private ClientDao clientDao;

    private PotentialClientService potentialClientService;

    @Before
    public void setUp() {
        this.potentialClientDao = mock(PotentialClientImpl.class);
        this.clientDao = mock(ClientDaoImpl.class);
        this.potentialClientService = new PotentialClientServiceImpl(this.potentialClientDao, this.clientDao);
    }

    @Test(expected = ExistException.class)
    public void saveNaturalPotentialClinetIfExistOnClient() throws Exception {
        PotentialClient potentialClient = new PotentialClient();
        potentialClient.type = ClientType.NATURAL;
        potentialClient.identityCard = "23424334";
        Optional expectedOptional = Optional.ofNullable(potentialClient);

        when(clientDao.getTransaction()).thenReturn(new FakeTransaction());
        when(this.clientDao.existClientNatural(potentialClient.identityCard)).thenReturn(expectedOptional);
        this.potentialClientService.save(potentialClient);
    }

    @Test(expected = ExistException.class)
    public void saveLegalPotentialClinetIfExistOnClient() throws Exception {
        PotentialClient potentialClient = new PotentialClient();
        potentialClient.type = ClientType.LEGAL;
        potentialClient.businessName = "Empresa Test";
        potentialClient.nit = "12121212121212";
        Optional expectedOptional = Optional.ofNullable(potentialClient);

        when(clientDao.getTransaction()).thenReturn(new FakeTransaction());
        when(this.clientDao.existClientLegal(potentialClient.businessName, potentialClient.nit)).thenReturn(expectedOptional);
        this.potentialClientService.save(potentialClient);
    }

    @Test(expected = ExistException.class)
    public void saveNaturalPotentialClinetIfExistOnPotentialClient() throws Exception {
        PotentialClient potentialClient = new PotentialClient();
        potentialClient.type = ClientType.NATURAL;
        potentialClient.identityCard = "23424334";
        Optional expectedOptional = Optional.ofNullable(potentialClient);

        when(clientDao.getTransaction()).thenReturn(new FakeTransaction());
        when(this.potentialClientDao.existClientNatural(potentialClient.identityCard)).thenReturn(expectedOptional);
        this.potentialClientService.save(potentialClient);
    }

    @Test(expected = ExistException.class)
    public void saveLegalPotentialClinetIfExistOnPotentialClient() throws Exception {
        PotentialClient potentialClient = new PotentialClient();
        potentialClient.type = ClientType.LEGAL;
        potentialClient.businessName = "Empresa Test";
        potentialClient.nit = "12121212121212";
        Optional expectedOptional = Optional.ofNullable(potentialClient);

        when(clientDao.getTransaction()).thenReturn(new FakeTransaction());
        when(this.potentialClientDao.existClientLegal(potentialClient.businessName, potentialClient.nit)).thenReturn(expectedOptional);
        this.potentialClientService.save(potentialClient);
    }

    @Test
    public void saveNaturalPotentialClinet() throws Exception {
        PotentialClient potentialClient = new PotentialClient();
        potentialClient.type = ClientType.NATURAL;
        potentialClient.identityCard = "23424334";
        long expected = potentialClient.id;

        when(clientDao.getTransaction()).thenReturn(new FakeTransaction());
        when(potentialClientDao.save(potentialClient)).thenReturn(expected);
        this.potentialClientService.save(potentialClient);
    }

    @Test
    public void saveLegalPotentialClinet() throws Exception {
        PotentialClient potentialClient = new PotentialClient();
        potentialClient.businessName = "Empresa Test";
        potentialClient.nit = "12121212121212";
        long expected = potentialClient.id;

        when(clientDao.getTransaction()).thenReturn(new FakeTransaction());
        when(potentialClientDao.save(potentialClient)).thenReturn(expected);
        this.potentialClientService.save(potentialClient);
    }


}

class FakeTransaction implements Transaction{

    @Override
    public TransactionStatus getStatus() {
        return null;
    }

    @Override
    public void registerSynchronization(Synchronization synchronization) throws HibernateException {

    }

    @Override
    public void setTimeout(int i) {

    }

    @Override
    public int getTimeout() {
        return 0;
    }

    @Override
    public void begin() {

    }

    @Override
    public void commit() {

    }

    @Override
    public void rollback() {

    }

    @Override
    public void setRollbackOnly() {

    }

    @Override
    public boolean getRollbackOnly() {
        return false;
    }

    @Override
    public boolean isActive() {
        return false;
    }
}