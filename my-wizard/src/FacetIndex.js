let FacetComponents = {};

FacetComponents['Facet']    = require('./facets/Identity/IdentityFacet').default;
FacetComponents['Identity'] = require('./facets/Identity/IdentityFacet').default;
FacetComponents['AuthMode'] = require('./facets/AuthMode/AuthModeFacet').default;
FacetComponents['Document'] = require('./facets/Document/DocumentFacet').default;
/// TODO: Can we use dynamic imports!? 


export default FacetComponents
