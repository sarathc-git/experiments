import './Facet.css';
import React from 'react';
import FacetComponents from './FacetIndex';


 function   renderer (item) {
        let config = item.config;

        console.log ("-- Inside the facet renderer");
        console.log ("Need to render " + item.code );
        
        return React.createElement ( 
            FacetComponents[item.code],
                {facet : item}, 
                null); 
    }

export default renderer;