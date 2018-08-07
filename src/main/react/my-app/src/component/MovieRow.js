import React from 'react'

class MovieRow extends React.Component {

    viewMovie() {
        window.location.href = "https://www.themoviedb.org/movie/" + this.props.movieInfo.id
    }
    render() {
        return (
            <table key={this.props.movieInfo.id}>
                <tbody>
                <tr>
                    <td>
                        <img alt="poster" width="120" src={this.props.movieInfo.poster_src}/>
                    </td>
                    <td>
                        <h3> {this.props.movieInfo.title} </h3>
                        <p>{this.props.movieInfo.overview}</p>
                        <input type="button" onClick={this.viewMovie.bind(this)} value="View" />
                    </td>
                </tr>
                </tbody>
            </table>
        )
    }
}

export default MovieRow