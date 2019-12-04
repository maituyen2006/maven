package com.team5solution.Facades;

import com.team5solution.Entities.Supplier;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SupplierFacade extends AbstractFacade {

    public SupplierFacade() {
        super(Supplier.class);
    }


}
