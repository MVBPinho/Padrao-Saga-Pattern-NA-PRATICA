package com.arantes.sale.adapters.out.repository.mapper;

import com.arantes.sale.adapters.out.repository.entity.SaleEntity;
import com.arantes.sale.application.core.domain.Sale;
import com.arantes.sale.application.core.domain.enums.SaleStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface SaleEntityMapper {

    @Mapping(source = "status", target = "statusId", qualifiedByName = "setStatusId")
    SaleEntity toSaleEntity(Sale sale);

    @Named("setStatusId")
    default Integer setStatusId(SaleStatus saleStatus) {
        return saleStatus.getStatusId();
    }

    @Mapping(target = "status", source = "statusId", qualifiedByName = "setStatus")
    Sale toSale(SaleEntity saleEntityO);

    @Named("setStatus")
    default SaleStatus setStatus(Integer saleStatusId) {
        return SaleStatus.toEnum(saleStatusId);
    }
}
