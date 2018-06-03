import React, { Component } from 'react';

class Form extends Component {
    state = {
        location: "",
        searchTerm: "",
        price: "",
        sortBy: "rating",
        openNow: "",
        openAt: ""
    }

    change = e => {
        console.log("NAME: " + e.target.name + " VALUE: " + e.target.value);
        this.setState({
            [e.target.name]: e.target.value
        });
    }

    clearState() {
        this.setState({
            location: "",
            searchTerm: "",
            price: "",
            sortBy: "rating",
            openNow: "",
            openAt: ""
        });
    }

    onSubmit = (e) => {
        e.preventDefault();
        var newYelp = this.state;
        this.props.createYelp(newYelp);
        this.clearState();
    }

    render() {
        return (
            <form>
                <input
                    name = "location"
                    placeholder='location'
                    value = {this.state.location}
                    onChange={e => this.change(e)}
                />
                <br/>
                <input
                    name = "searchTerm"
                    placeholder='Search Term'
                    value = {this.state.searchTerm}
                    onChange={e => this.change(e)}
                />
                <br/>
                <input
                    name = "price"
                    placeholder = 'Price'
                    value = {this.state.price}
                    onChange={e => this.change(e)}
                />
                <br/>
                <input
                    name = "sortBy"
                    placeholder='Sort Search By'
                    value = {this.state.sortBy}
                    onChange={e => this.change(e)}
                />
                <br/>
                <input
                    name = "openNow"
                    placeholder='Open Now'
                    value = {this.state.openNow}
                    onChange={e => this.change(e)}
                />
                <br/>
                <input
                    name = "openAt"
                    placeholder='Open At'
                    value = {this.state.openAt}
                    onChange={e => this.change(e)}
                />
                <br/>
                <button onClick={e => this.onSubmit(e)}>Submit</button>
            </form>
        )
    }
}

export default Form;