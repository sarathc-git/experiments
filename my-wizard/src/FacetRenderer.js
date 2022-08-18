import './Facet.css';
import React from 'react';
import FacetComponents from './FacetIndex';


 function   renderer (facet) {
        let config = facet.config;

        console.log ("-- Inside the facet renderer");
        console.log ("Need to render " + facet.code );
        if (!hasChildren) {
            return React.createElement ( 
                FacetComponents[facet.code],
                    {facet : facet}, 
                    null);
        } else {
            return React.createElement ( 
                FacetComponents[facet.code],
                    {facet : facet}, 
                    facets);
        }
        
    }

export default renderer;