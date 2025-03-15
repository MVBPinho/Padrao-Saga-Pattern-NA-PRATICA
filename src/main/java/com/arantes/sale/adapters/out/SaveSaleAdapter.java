package com.arantes.sale.adapters.out;

import com.arantes.sale.adapters.out.repository.SaleRepository;
import com.arantes.sale.adapters.out.repository.mapper.SaleEntityMapper;
import com.arantes.sale.application.core.domain.Sale;
import com.arantes.sale.application.ports.out.SaveSaleOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveSaleAdapter implements SaveSaleOutputPort {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleEntityMapper saleEntityMapper;

    @Override
    public Sale sale(Sale sale) {
        var saleEntity = saleEntityMapper.toSaleEntity(sale);
        var saleEntityResponse = saleRepository.save(saleEntity);
        return saleEntityMapper.toSale(saleEntityResponse);
    }
}
