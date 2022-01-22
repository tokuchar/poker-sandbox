import groovyx.net.http.ContentType
import groovyx.net.http.HttpResponseDecorator
import groovyx.net.http.RESTClient
import spock.lang.Shared
import spock.lang.Specification

class BasicPokerTest extends Specification {
    @Shared
    def client = new RESTClient("http://localhost:8080")

    def 'should return 200 codes when deal cards and get it'() {
        when: 'deal for 5 players'
        client.contentType = ContentType.JSON

        HttpResponseDecorator createDealResponse = client.post(
                path: "/deal",
                body: ["numberOfSlots": 5]
        )

        then: 'server returns CREATED'
        assert createDealResponse.status == 201

        print("dealId " + createDealResponse.responseData)

        and: 'get previously deal'
        HttpResponseDecorator cards = client.get(
                path: "/deal/" + createDealResponse.responseData
        )

        then: 'response is OK'
        assert cards.status == 200
    }
}
