import './Wizard.css';
import React from 'react';
import FacetComponents from './FacetIndex';
import RenderFacet from './FacetRenderer';
import { useEffect, userState } from 'react';
import { toHaveDisplayValue } from '@testing-library/jest-dom/dist/matchers';

class Wizard extends React.Component {
  constructor(props) {
    super(props)
    // TODO : This should be loaded from a http call. 
    this.state = {
      currentFacet: 1
    }


    this.config = this.getWizardConfig();

    this.container = {
      id: 1234,
      lastFacetSubmitted : 3,
      facets: [
        /// Facet Data ! 
        { code: "Identity"},
        { code: "AuthMode"},
        { code: "Document", type:"KTP", meta:"status:" }
      ]
    }

    // The container is the object that has the state of the flow and the facets in the flow.  
  }

  getContainer (id) {

  }


  render() {
    let facetToRender = this.getFacetToRender(this.state.currentFacet);
    console.log("------- the current Facet is " + this.state.currentFacet);

    return (
      <div>
        <h2>Welcome to {this.config.name} flow:</h2>

        <div className="facet">
            {RenderFacet(facetToRender)}
        </div>

        <div className="navigation">
          <button name="previous"
            onClick={() => this.setState(
              { currentFacet: this.state.currentFacet - 1 })
            }> Previous </button>

          <button name="next"
            onClick={() => this.setState(
              { currentFacet: this.state.currentFacet + 1 })
            }> Next </button>
        </div>
      </div>
    )
  }

  onYield(event) {
    this.setState(
      { currentFacet: this.state.currentFacet + 1 });
  }

  componentDidUpdate() {
    RenderFacet(this.state.currentFacet);
  }

  getFacetToRender(seq) {
    // If Container is empty (new flow)
    var defaultFacet = this.config.facets.find(aFacet => aFacet.seq === seq);
    console.log("returning facet " + defaultFacet);
    return defaultFacet;
  }

  getWizardConfig() {
    return {
      name: "Sample Wizard",
      facetToRender: 1,
      context: "vn",

      facets: [
        {
          type: "facet", done: true, seq: 1,
          name: "Create User", code: "Identity",
          config:
          {
            type: "phone",
            meta: { owner: "Entity", status: "approved" }
          }
        },

        {
          type: "facet", done: false, seq: 2,
          name: "Ener OTP", code: "AuthMode",
          config: {
            type: "password",
            meta: { owner: "Identity" }
          }
        },
       
        {
            type: "facet", done: false, seq: 3,
            name: "Upload KTP", code: "Document",
            config: {
              type: "KTP",
              meta: { owner: "User" }
            }
          },

          {
            type: "facet", done: false, seq: 4,
            name: "Document Uplaod", code: "Document",
            config: {
              type: "Passport",
              meta: { owner: "Identity" }
            }
          }
       
        ]

    }

  }

}

export default Wizard;

// {this.config.facets.map(facet => RenderFacet(facet)
// )}