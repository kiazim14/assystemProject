package com.springboot.converter;

import com.springboot.dto.ProductVariantDTO;
import com.springboot.entity.ProductVariant;
import com.springboot.response.ProductVariantResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductVariantResponseConverterImpl implements ProductVariantResponseConverter {
        @Override
        public ProductVariantResponse apply(ProductVariant productVariant) {

            return null;
        }
}
//            ProductVariantResponse productVariantResponse = new ProductVariantResponse();
//            productVariantResponse.setId(productVariant.getId());
////            productVariantResponse.setName(productVariant.getProduct().getName());
////            productVariantResponse.setUrl(productVariant.getProduct().getUrl());
////            productVariantResponse.setProductVariant(ProductVariantDTO
//                    .builder()
//                    .id(productVariant.getId())
//                    .price(productVariant.getPrice())
//                    .thumb(productVariant.getThumb())
//                    .stock(productVariant.getStock()).build());
////                    .color(ColorDTO
////                            .builder()
////                            .name(productVariant.getColor().getName())
////                            .hex(productVariant.getColor().getHex())
////                            .build())
////                    .build()
////            );
//
//            return productVariantResponse;
 //       }
 //   }



