# POC for the FE wizard and facet interaction
    One of the key components of the new faceted architecture is the wizard which is a light weight 
    orchestrator for the various flow that we expect to configure based on the facets being available

    This is a proposal / POC that highlights some of the key interactions and how the wizard and the facets can eixst with a loosely coupled, but well defined contract. 
    
# Goals 
    Some of the key goals we want to achieve with the FE solution are as follows:

    1. Ensure that facets once built, are reusable for various flows with minimal changes. 
    1. The wizard should be relatively independent of the fuctioning of a Facet. 
    1. The facet gets the configuration and the data from the wizard and uses this to render its views. 
    1. Each facet has a clear protocol of **Render**, **Submit** and **Yeild** 
    1. Navigation of the flow from one facet to another facet is orchestrated by the wizard based on events from the facet. 
    1. The Wizard should support a single train of facets one after the other. 
    1. The wizard should allow configuration of ensuring that a few facets can be collected together, to be shows as an Accordian, Grid of other kind of pluggable decorations.

# Prerequisites / Constraints 
    This solution proposes to allow multiple flows to be implemented as configurations. So there are constraints and pre-requisites. 
    1. The wizard can allow configuration of flows based on the facets that are ready from a FE, BE, and lifecycle perspective. 
    1. Every flow will be configured to ensure that the boundaries of a facet is not broken. (For example, there cannot be a view / wizard step, where fields from multiple facets are interleaved.)
    1. The front end view components / fragments provided by the facet will be the lowest level of components. 


# Interfaces
    The wizard and the facet have clear interfaces proposed that allow for seamless integrations. 

## Wizard
    The wizard is the FE manifestation of the container. Every container/wizard has the following interfacets. 

### Config API
    When we need to launch a new flow, the various aspects of the wizard in terms of templates, themes and the train of facets that will be part of the flow will be available as a configuration of the wizard. 

### Container API 
    Every wizard is a FE manifestation of the Container object. Each container represents an individual instance of a merchant going through the flow. This container object aggregates the data that has been submitted to the facets and the various lifecycle events of the facets and the flow itself. 

### render 
    Every wizard follows the react component contract of being rendered in the pages. 

### OnYield 
    Every facet when it no longer needs the attention of the user, decides to relenquish control and createa yield event that the wizard will handle. When the facet confirms that it is yield the control of the user, the wizard then identifies the next facet to render and delegates to that facet to render itself. 

## Facet 
    Every facet component also has a consistent well defined contract. 
### Render 
    Every facet will follow the react component contract to render the relevant view based on the status of the facet. 
    For example, if the the wizard delegates to the Outlet facet to render itself, the outlet facet will look at the container and the config to render the view that is most relevant. 

### onSubmit / onNext / onSave 
    The wizard provides the navigation where the customer clicks on the navigation button for the facet to submit the data to the facets. 

### yield Event. 
    The facet based on the submission and status can decicde to either retain user attention or relinquish control. When it decides to relinquish control, it generates the Yield event which is consumed by the wizard. 


