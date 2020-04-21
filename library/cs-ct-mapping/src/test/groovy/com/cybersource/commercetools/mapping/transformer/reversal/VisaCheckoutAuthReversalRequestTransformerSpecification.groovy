package com.cybersource.commercetools.mapping.transformer.reversal

import com.cybersource.commercetools.mapping.model.CybersourceIds
import com.cybersource.commercetools.mapping.transformer.fieldgroup.AuthReversalServiceFieldGroupTransformer
import com.cybersource.commercetools.mapping.transformer.fieldgroup.BaseFieldGroupTransformer
import com.cybersource.commercetools.mapping.transformer.fieldgroup.PurchaseTotalsFieldGroupTransformer
import com.cybersource.commercetools.mapping.transformer.fieldgroup.VisaCheckoutFieldGroupTransformer
import spock.lang.Specification

class VisaCheckoutAuthReversalRequestTransformerSpecification extends Specification {

    def testObj

    def 'should configure required field group transformers'() {
        given:
        def cybersourceIds = new CybersourceIds()

        when:
        testObj = new VisaCheckoutAuthReversalRequestTransformer(cybersourceIds)

        then:
        testObj.fieldGroupTransformers.size() == 4
        testObj.fieldGroupTransformers[0] instanceof BaseFieldGroupTransformer
        testObj.fieldGroupTransformers[0].cybersourceIds == cybersourceIds
        testObj.fieldGroupTransformers[1] instanceof AuthReversalServiceFieldGroupTransformer
        testObj.fieldGroupTransformers[2] instanceof PurchaseTotalsFieldGroupTransformer
        testObj.fieldGroupTransformers[3] instanceof VisaCheckoutFieldGroupTransformer
    }
}
