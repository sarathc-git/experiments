import './AuthMode.Facet.css';
import React from 'react';

class AuthModeFacet extends React.Component {
    constructor(props) {
        super(props);
        console.log (props.facet.seq); 

        console.log ("++++ Inside AuthMode facet " + props);
        console.log (" the facet code is " + props.facet.code);

        this.config = props.facet.config;
    }

    render() {
        let facet = this.props.facet;
        let config = this.props.facet.config;

        console.log  ("Inside the AuthMode facet render");
        

        return (
            <div className="facet" key={facet.seq}>
                <span className={facet.done ? "done" : ""}>
                    {facet.seq} --- {facet.code}  -- {config.type} -- {facet.name}
                </span>
            </div>
        )
    }

}

export default AuthModeFacet;
