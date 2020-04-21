package com.cybersource.commercetools.mapping.transformer.fieldgroup

import com.cybersource.commercetools.mapping.model.PaymentDetails
import com.cybersource.commercetools.mapping.model.CustomPayment
import spock.lang.Specification

class VisaCheckoutFieldGroupTransformerSpecification extends Specification {

    def testObj = new VisaCheckoutFieldGroupTransformer()

    def 'Should return a valid field group when transforming a payment with a token value'() {
        given:
        def paymentMock = Mock(CustomPayment)
        paymentMock.token >> 'someToken'

        def paymentDetailsMock = Mock(PaymentDetails)
        paymentDetailsMock.customPayment >> paymentMock

        when:
        def result = testObj.configure(paymentDetailsMock)

        then:
        result.size() == 1
        result[0].orderID == 'someToken'
    }
}
