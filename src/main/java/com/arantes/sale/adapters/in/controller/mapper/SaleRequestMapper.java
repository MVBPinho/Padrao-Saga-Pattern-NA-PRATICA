package com.arantes.sale.adapters.in.controller.mapper;

import com.arantes.sale.adapters.in.controller.request.SaleRequest;
import com.arantes.sale.application.core.domain.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleRequestMapper {

    Sale toSale(SaleRequest saleRequest);
}
