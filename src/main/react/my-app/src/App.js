import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import MovieRow from './component/MovieRow.js'
import $ from 'jquery'

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {}
        this.performSearch("Lord of the rings")
    }

    searchChangeHandler(e) {
        console.log(e.target.value);
        const boundObject = this
        const searchTerm = e.target.value
        boundObject.performSearch(searchTerm)
    }

    performSearch(searchTerm) {
        console.log("Perform search using MovieDB API");
        const urlString = "https://api.themoviedb.org/3/search/movie?query=" + searchTerm + "&api_key=034724580654e7d5ec55f1fa8f5551d2";
        $.ajax({
            url: urlString,
            success: (searchResults) => {
                console.log("Fetched Data successfully");
                const results = searchResults.results

                var movieRows = []
                results.forEach((movie) => {
                    movie.poster_src = "https://image.tmdb.org/t/p/w185/" + movie.poster_path
                    const movieRow = <MovieRow key={movie.id} movieInfo={movie} />
                    movieRows.push(movieRow)
                })

                this.setState({rows: movieRows})
            },
            error: (xhr, status, err) => {
                console.log("Failed to fetch data");
            }

        })
    }

    render() {
        return (
            <div className="App">

                <table className="title-bar">
                    <tbody>
                        <tr>
                            <td>
                                <img width="50" src={logo} alt="App Icon" />
                            </td>
                            <td>
                                <h1>MovieDB Search</h1>
                            </td>
                        </tr>
                    </tbody>
                </table>

                <input style={{
                    fontSize: 24,
                    display: 'block',
                    width: "99%",
                    paddingTop: 8,
                    paddingBottom: 8,
                    paddingLeft: 15
                }} onChange={this.searchChangeHandler.bind(this)} placeholder="Enter Search Term"/>

                {this.state.rows}

            </div>
        );
    }
}

export default App;
