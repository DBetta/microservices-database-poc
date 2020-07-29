const {ApolloServer} = require("apollo-server");
const {ApolloGateway} = require("@apollo/gateway");

const server = new ApolloServer({
    gateway: new ApolloGateway({
        debug: true,
        serviceList: [
            {name: "client-service", url: "http://localhost:8762/client-service/graphql"},
            {name: "quotation-service", url: "http://localhost:8762/quotation-service/graphql"}

        ]
    }),
    subscriptions: false
});

server.listen().then(({url}) => {
    console.log(`🚀 Server ready at ${url}`);
});
