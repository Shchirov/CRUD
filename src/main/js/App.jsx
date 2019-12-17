import React from "react";
import ReactDom from 'react-dom';
import {Row} from './Row.jsx';

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {maxPos: 0, rows: [/*{id: null, text: null, changed: false}*/]};
        this.addRow = this.addRow.bind(this);
        this.save = this.save.bind(this);
        this.remove = this.remove.bind(this);
        this.textUpdate = this.textUpdate.bind(this);
        this.updateRows = this.updateRows.bind(this);
        this.updatePos = this.updatePos.bind(this);
    }

    componentDidMount() {
        this.updateRows();

    }

    updatePos(value) {
        if (value > this.state.maxPos)
            this.setState({maxPos: value});
    }

    updateRows() {
        let updatePos = this.updatePos;
        fetch('http://localhost:7070/message/', {
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            }
        })
            .then(res => res.json())
            .then(res => {
                this.setState({rows: res.map(x => ({id: x.id, text: x.text, changed: false}))});
                this.state.rows.map(function(o) { updatePos(o.id) });
            });
    }

    remove(rowId) {
        this.setState({rows: this.state.rows.filter(item => (item.id !== rowId))});
    }

    addRow() {
        let newRow = this.state.rows;
        newRow.unshift({id: this.state.maxPos + 1, text: ""});
        this.setState({maxPos: this.state.maxPos + 1, rows: newRow});
    }

    save() {
        let data = this.state
            .rows
            .filter(x => x.changed);
        fetch('http://localhost:7070/message/', {
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            method: 'POST'
        })
            .then(res => res.text())
            .then(res => {
                this.updateRows();
            });

    }

    textUpdate(id, text) {
        if (text === "") {
            this.remove(id);
        } else {
            let data = this.state
                .rows
                .map(function (r) {
                    if (r.id != id) {
                        return r;
                    } else {
                        return {id: r.id, text: text, changed: text !== r.text};
                    }
                });
            this.setState({rows: data});
        }
    }

    render() {
        return (
            <div id="app">
                <div id="buttons">
                    <button id="add" onClick={this.addRow}>+</button>
                    <button id="save" onClick={this.save}>Сохранить</button>
                </div>
                <div id="rows">
                    {
                        this.state
                            .rows
                            .map((row, index) => (
                                    <Row id={row.id} text={row.text} remove={this.remove} key={row.id}
                                         added={row.text === ""} textUpdate={this.textUpdate} changed={row.changed}/>
                            ))
                    }
                </div>
            </div>
        )
    }
}

ReactDom.render(<App/>, document.getElementById("react"));