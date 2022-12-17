# graphql

mutation {
  addGadget (gadget: {cost:299,country:"china",name:"AIRPODS PRO"}) {id,cost,country}
}


query {
  getGadgets {
    id
    cost
    name
    country
    versions {
      id
      gadgetId
      
    }
  }
}
