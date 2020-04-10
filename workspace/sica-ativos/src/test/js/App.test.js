import React from 'react';
import { render } from '@testing-library/react';
import App from './App';

test('renders learn SICA', () => {
  const { getByText } = render(<App />);
  const linkElement = getByText(/SICA/i);
  expect(linkElement).toBeInTheDocument();
});
