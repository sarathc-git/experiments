import './Identity.Facet.css';
import React from 'react';

class IdentityFacet extends React.Component {
    constructor(props) {
        super(props);
        console.log (props.facet.seq); 

        console.log ("++++ Inside Identity facet " + props);
        console.log (" the facet code is " + props.facet.code);

        this.config = props.facet.config;

    }

    render() {
        let facet = this.props.facet;
        let config = this.props.facet.config;
        let status = "new";

        console.log  ("Inside the Identity facet render");
        if (status ==="new") {
        return ( <div className="facet" key={facet.seq}>
            <span key={facet.seq}>
                {facet.seq} --- {facet.code}  -- {config.type} -- {facet.name}
            </span>
        </div>)
        }  
    }

    onSubmit (event) {

        
    }

}

export default IdentityFacet;
